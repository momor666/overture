package org.overture.interpreter.tests;

import java.io.File;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.overture.ast.lex.Dialect;

@RunWith(value = Parameterized.class)
public class ModulesSlTest extends CommonInterpreterTest
{

	public ModulesSlTest(Dialect dialect, String suiteName, File testSuiteRoot,
			File file)
	{
		super(dialect, file, suiteName, testSuiteRoot);
	}

	@Parameters(name = "{1}")
	public static Collection<Object[]> getData()
	{
		String root = "src/test/resources/modules/complete/";

		Collection<Object[]> tests = TestSourceFinder.createTestCompleteFile(Dialect.VDM_SL, "", root, "vdmsl", "");

		remove(tests, "soccer");

		return tests;
	}

	private static void remove(Collection<Object[]> tests, String string)
	{
		Object[] item = null;
		for (Object[] objects : tests)
		{
			if (objects[1].toString().equals(string+".vdmsl"))
			{
				item = objects;
				break;
			}
		}
		if (item != null)
		{
			tests.remove(item);
		}
	}

	@Override
	protected String getPropertyId()
	{
		return "modules";
	}

}
