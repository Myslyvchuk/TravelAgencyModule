package com.softserve.edu.ita;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;

import com.softserve.edu.ita.dao.DaoFactory;
import com.softserve.edu.ita.entity.Country;

import config.DBUnitConfig;

public class ElementTest extends DBUnitConfig {
	class CountryService {
		public void addCountry(Country country) {
			DaoFactory.getInstance().getCountryDao().addElement(country);
		}

		public List<Country> getAllCountry() {
			return DaoFactory.getInstance().getCountryDao().getAllElements();
		}

	}

	private CountryService cos = new CountryService();

	@Before
	public void setUp() throws Exception {
		super.setUp();
		beforeData = new FlatXmlDataSetBuilder().build(Thread
				.currentThread()
				.getContextClassLoader()
				.getResourceAsStream(
						"com/softserve/edu/ita/test/country-data.xml"));

		tester.setDataSet(beforeData);
		tester.onSetup();

	}

	protected void tearDown() throws Exception {
		tester.onTearDown();
	}

	public ElementTest(String name) {
		super(name);
	}

	@SuppressWarnings("deprecated")
	@Test
	public void testGetAll() throws Exception {
		List<Country> countryList = cos.getAllCountry();

		IDataSet databaseDataSet = getConnection().createDataSet();
		ITable actualTable = databaseDataSet.getTable("country");

		IDataSet expectedDataSet = new FlatXmlDataSetBuilder()
				.build(new File(
						"src/test/resources/com/softserve/edu/ita/test/country-data.xml"));
		ITable expectedTable = expectedDataSet.getTable("country");

		Assertion.assertEquals(expectedTable, actualTable);

	}
	
	@Test
	public void testSave() throws Exception {
		Country country = new Country();
		country.setCountry("Australia");
		CountryService cos1 = new CountryService();
		cos1.addCountry(country);

		IDataSet databaseDataSet = getConnection().createDataSet();
		ITable actualTable = databaseDataSet.getTable("country");

		IDataSet expectedDataSet = new FlatXmlDataSetBuilder()
				.build(new File(
						"src/test/resources/com/softserve/edu/ita/test/country-data-save.xml"));
		ITable expectedTable = expectedDataSet.getTable("country");

		Assertion.assertEquals(expectedTable, actualTable);
	}

	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Test public void testGetAll() throws Exception { List<Country> country =
	 * cos.getAllCountry();
	 * 
	 * IDataSet expectedData = new FlatXmlDataSetBuilder().build(Thread
	 * .currentThread() .getContextClassLoader() .getResourceAsStream(
	 * "com/softserve/edu/ita/test/country-data.xml"));
	 * 
	 * IDataSet actualData = tester.getConnection().createDataSet(); String[]
	 * ignore = { "id" }; Assertion.assertEquals(expectedData, actualData);
	 * Assert.assertEquals(expectedData.getTable("country").getRowCount(),
	 * country.size());
	 * 
	 * 
	 * IDataSet databaseDataSet = getConnection().createDataSet(); ITable
	 * actualTable = databaseDataSet.getTable("country");
	 * 
	 * IDataSet expectedDataSet = new FlatXmlDataSetBuilder() .build(new File(
	 * "src/test/resources/com/softserve/edu/ita/test/country-data.xml"));
	 * ITable expectedTable = expectedDataSet.getTable("country");
	 * 
	 * Assertion.assertEquals(expectedTable, actualTable);
	 * 
	 * }
	 */

	

		/*
		 * IDataSet expectedData = new FlatXmlDataSetBuilder().build(Thread
		 * .currentThread() .getContextClassLoader() .getResourceAsStream(
		 * "com/softserve/edu/ita/test/country-data-save.xml"));
		 * 
		 * IDataSet actualData = tester.getConnection().createDataSet();
		 * String[] ignore = { "id" };
		 * Assertion.assertEqualsIgnoreCols(expectedData, actualData, "country",
		 * ignore);
		 */

	

}
