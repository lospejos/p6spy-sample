CREATE TABLE person (
  id INT AUTO_INCREMENT,
  name VARCHAR(10) NOT NULL UNIQUE,
  PRIMARY KEY (id)
);

/*
CREATE ALIAS GET_ORDERS_WITH_VALID_ITEMS AS  $$
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;
@CODE
ResultSet getOrdersWithValidItems(final Connection conn, final String searchKey, final String customer, final String date) throws SQLException
{

  final Collection<String> recordsWithoutValidity = new HashSet<String>();
  final Collection<String> validRecords = new HashSet<String>();

  // get records without validity information
  StringBuffer sql = new StringBuffer();
  sql.append("SELECT DISTINCT ITEM FROM ITEMS ");
  sql.append("WHERE CUSTOMER='" + customer + "' ");
  sql.append("AND KEY='" + searchKey + "' ");
  sql.append("AND VALID FROM IS NULL ");
  PreparedStatement ps = conn.prepareStatement(sql.toString());
  ResultSet results = ps.executeQuery();
  while (results.next())
    recordsWithoutValidity.add(results.getString("ITEM"));

  // get valid records
  sql = new StringBuffer();
  sql.append("SELECT TOP 1 ITEM FROM ITEMS ");
  sql.append("WHERE CUSTOMER='" + customer + "' ");
  sql.append("AND KEY='" + searchKey + "' ");
  sql.append("AND " + date + " BETWEEN VALID_FROM AND VALID_TO ");
  sql.append("ORDER BY VALID_FROM DESC;");

  ps = conn.prepareStatement(sql.toString());
  results = ps.executeQuery();
  while (results.next())
    validRecords.add(results.getString("ITEM"));

  final Collection<String> allRecords = new HashSet<String>();
  allRecords.addAll(recordsWithoutValidity);
  allRecords.addAll(validRecords);
  final String allRecordsString = allRecords.stream().map(item -> "'" + item + "'").collect(Collectors.joining(
   ","));

  sql = new StringBuffer();
  sql.append("SELECT ORDER_ID FROM ORDERS ");
  sql.append("WHERE ITEM IN (" + allRecordsString + ")");
  ps = conn.prepareStatement(sql.toString());
  return ps.executeQuery();
}
$$;

*/