package DBOperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import util.DBUtils;

import entity.CustomerPhoneNumber;

public class PhoneNumberOperations {
	public static final String ACCOUNT_SID = "AC9d9e5a6977260eccbc48592b620e7d0c";
	public static final String AUTH_TOKEN = "579109b37aed286cf1f0f0cae0a083c0";

	public static ArrayList<CustomerPhoneNumber> retriveAllNumbers() {
		String query = "SELECT * FROM phone_numbers";
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<CustomerPhoneNumber> phoneNumbers = new ArrayList<CustomerPhoneNumber>();
		try {
			stmt = DBUtils.CONN.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				CustomerPhoneNumber phoneNumber = new CustomerPhoneNumber();
				phoneNumber.setID(rs.getInt(1));
				phoneNumber.setPhoneNumber(rs.getString(2));
				phoneNumbers.add(phoneNumber);
			}

			return phoneNumbers;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void sendMessages(ArrayList<String> toPhoneNumbers) {
		System.out.println(toPhoneNumbers.size());

	}

	public static void sendLinks(ArrayList<String> toPhoneNumbers) {
		System.out.println(toPhoneNumbers.size());
		for (String toNumber : toPhoneNumbers) {
			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			
			// String toNumber = "+61450258868";
			String fromNumber = "+61438976504";
			Message message = Message.creator(new PhoneNumber(toNumber),
					new PhoneNumber(fromNumber),
					"http://118.138.42.206:4567/hello/" + toNumber).create();
			System.out.println(message.getSid());
		}

	}

}
