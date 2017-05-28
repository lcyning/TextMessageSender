package util;

public class uiUtils {

	/**
	 * Check if a String is a number with certain digits
	 * 
	 * @param s
	 *            Input String
	 * @param reqiredDigits
	 *            Required digits, 0 means any digits
	 * @return true is legal format; false is illegal format;
	 */
	public static boolean checkNumberFormat(String s, int reqiredDigits) {
		boolean flag = false;

		if (s.length() == reqiredDigits || reqiredDigits == 0) {
			try {
				double temp = Double.parseDouble(s);
				if (temp > 0) {
					flag = true;
				} else {
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;
	}

	/**
	 * Check String is a legal year format
	 * 
	 * @param s
	 *            Input String
	 * @return true if is legal format; false if illegal format
	 */
	public static boolean checkYear(String s) {
		boolean flag = false;
		if (s.length() == 4) {
			try {
				int temp = Integer.parseInt(s);
				if (temp > 0 && temp <= 2017) {
					flag = true;
				} else {
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;
	}

}
