package org.overture.ide.ui.utility;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.overture.ide.core.IVdmModel;
import org.overture.ide.core.resources.IVdmProject;

public class VdmTypeCheckerUi
{
	// public static boolean typeCheck(Shell shell, final IVdmProject project)
	// {
	// Assert.isNotNull(shell, "Shell for type checker cannot be null");
	// Assert.isNotNull(project, "Project for type checker cannot be null");
	//
	// IWorkbench wb = PlatformUI.getWorkbench();
	// IProgressService ps = wb.getProgressService();
	//
	// Job job1 = new Job("Type checker")
	// {
	//
	// @Override
	// protected IStatus run(IProgressMonitor monitor)
	// {
	// try
	// {
	// monitor.beginTask("xome tgsfkjk", 3);
	// Thread.sleep(3000);
	// } catch (InterruptedException e)
	// {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// // try
	// // {
	// // monitor.beginTask("Type checking project: "+ project.getName(), IProgressMonitor.UNKNOWN);
	// // if (project.typeCheck(monitor))
	// // {
	// return new Status(Status.OK, IVdmUiConstants.PLUGIN_ID, "Type check completed");
	// // }
	// // } catch (CoreException e)
	// // {
	// // return new Status(Status.ERROR, ICoreConstants.PLUGIN_ID, "Type check faild",e);
	// // }
	// // return new Status(Status.ERROR, ICoreConstants.PLUGIN_ID, "Type check faild");
	// }
	//
	// };
	//		
	// job1.setUser(true);
	// job1.setPriority(Job.INTERACTIVE);
	// ps.showInDialog(shell,job1);
	// job1.schedule();
	//		 
	// try
	// {
	// job1.join();
	// } catch (InterruptedException e)
	// {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//		
	//		
	// try
	// {
	// ps.busyCursorWhile(new IRunnableWithProgress() {
	// public void run(IProgressMonitor pm) {
	// try
	// {
	// pm.beginTask("test the service", 10);
	// Thread.sleep(5000);
	// pm.done();
	// } catch (InterruptedException e)
	// {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// });
	// } catch (InvocationTargetException e)
	// {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (InterruptedException e)
	// {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//		
	//		
	// return job1.getResult().isOK();
	//
	// // try
	// // {
	// // ps.busyCursorWhile(new IRunnableWithProgress() {
	// // public void run(IProgressMonitor pm) {
	// // try
	// // {
	// // pm.beginTask("test the service", 10);
	// // Thread.sleep(5000);
	// // pm.done();
	// // } catch (InterruptedException e)
	// // {
	// // // TODO Auto-generated catch block
	// // e.printStackTrace();
	// // }
	// // }
	// // });
	// }

	public static class CompletedStatus{
		private boolean completed;
		
		public synchronized boolean isCompleted()
		{
			return completed;
		}
		public synchronized void setCompledted()
		{
			completed = true;
		}
	}
	
	public static boolean typeCheck(Shell shell, final IVdmProject project)
	{
		Assert.isNotNull(shell, "Shell for type checker cannot be null");
		Assert.isNotNull(project, "Project for type checker cannot be null");
		
		final IVdmModel model = project.getModel();
		
		
		final CompletedStatus checkCompleted = new CompletedStatus();
		//TODO we may be able to use the istypechecked and istypecorrect in a better way here
		if(!model.getRootElementList().isEmpty() && model.isTypeCorrect() )
		{
			return true; //skip future checking to speed up the process
		}
		
		try
		{
			IRunnableWithProgress op = new IRunnableWithProgress()
			{

				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException
				{
					try
					{
						model.refresh(false, monitor);
						project.typeCheck(monitor);
						checkCompleted.setCompledted();

					} catch (CoreException e)
					{
						throw new InvocationTargetException(e);
					}

				}
			};
			new ProgressMonitorDialog(shell).run(true, true, op);
		} catch (InvocationTargetException e)
		{
			return false;
		} catch (InterruptedException e)
		{

		}
		
		while(!checkCompleted.isCompleted())
		{
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
			}
		}
		
		return project.getModel().isTypeCorrect();
	}
}
