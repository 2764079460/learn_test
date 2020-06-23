package com.markehub;


class VueblogApplicationTests {

	public static void main(String[] args) {
		System.out.println(addBinary("100","100"));//1000
		//'0' == 48
		//int aa = 0 + '0';
		//aa /= 2;

		/*StringBuffer vv = new StringBuffer("123456");
		vv.reverse();
		System.out.println(vv);*/
	}

	public static String addBinary(String a, String b) {
		StringBuffer ans = new StringBuffer();

		int n = Math.max(a.length(), b.length()), carry = 0;
		for (int i = 0; i < n; ++i) {
			//charAt(i)根据下标i拿字符
			/*carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;//1 (1+1)2
			carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;//(1+1)2 (2+0)2
			ans.append((char) (carry % 2 + '0'));//0 0
			carry /= 2;//(2/2)1 (2/2)1*/

			carry += i < a.length() ? (Integer.parseInt(a.charAt(a.length() - 1 - i)+"")) : 0;
			carry += i < b.length() ? (Integer.parseInt(b.charAt(b.length() - 1 - i)+"")) : 0;
			if (carry >= 2) {
				ans.append("0");
				carry = 1;
			} else {
				ans.append(carry+"");
				carry = 0;
			}
		}

		if (carry > 0) {
			ans.append('1');//"001"
		}
		//字符串前后翻转
		ans.reverse();

		return ans.toString();
	}

}
