package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!

public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   public void testManualTest()
   {
      //You can use this function to implement your manual testing
       UrlValidator url = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);

       assertTrue(url.isValid("http://www.google.com"));
       assertTrue(url.isValid("http://www.google.com/"));

       assertFalse(url.isValid("httpwww.google.com"));
       assertFalse(url.isValid("123456789"));
       assertFalse(url.isValid("https:www.google.com"));

   }

   public void testYourFirstPartition()
   {
	     //Using this function to test schemes
       UrlValidator url = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);

       assertTrue(url.isValid("http://www.google.com"));
       assertTrue(url.isValid("http://www.google.org"));
       assertTrue(url.isValid("http://www.google.gov"));
       assertTrue(url.isValid("http://www.google.edu"));

       assertFalse(url.isValid("://www.google.com"));
       assertFalse(url.isValid("htt//www.google.com"));
       assertFalse(url.isValid("httttp/www.google.com"));

   }

   public void testYourSecondPartition()
   {
  	 //Using this functions to test authorities
     UrlValidator url = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);

     assertTrue(url.isValidAuthority("http://www.google.com"));
     assertTrue(url.isValidAuthority("http://225.225.225.225"));

     assertFalse(url.isValidAuthority("http://1.3.4.5"));
     assertFalse(url.isValidAuthority(""));

   }

   //You need to create more test cases for your Partitions if you need to
   public void testYourThirdPartition()
   {
    //Using this function to test queries
    UrlValidator url = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);

    assertTrue(url.isValid("http://www.google.com/?action=view"));

    assertFalse(url.isValid("http://www.google.com//12345"));
    assertFalse(url.isValid(null));
    assertFalse(url.isValid("/.."));

   }

   public void testIsValid()
   {
	   //You can use this function for programming based testing
     UrlValidator url = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);

     String[] schemes = {"http://", "https://", "ftp://", "htp://", "://", "http//", "333"};
     String[] authorities = {"http://www.google.com", "http://www.wsj.com", "http://255.255.255.255",
                             "http://www.facebook.com", "http://", "http://518-5738135131.com",
                             "http://www."};
     String[] paths = {"/$23/", "/testpath/", "/challas/CS362/", "/..", "", "&&&&&"};

     //Test the schemes
     for (int i = 0; i < 7; i++){
       if (i > 0 && i < 5){
          String testString = schemes[i] + "www.google.com";
          assertTrue(url.isValid(testString));
       }
       else {
         String testString = schemes[i] + "www.google.com";
         assertFalse(url.isValid(testString));
       }
     }

     //Test the authorities
     for (int j = 0; j < 7; j++){
       if (j > 0 && j < 5){
          String testString = authorities[j];
          assertTrue(url.isValid(testString));
       }
       else {
         String testString = authorities[j];
         assertFalse(url.isValid(testString));
       }
     }

     //Test the paths
     for (int k = 0; k < 6; k++){
       if (k > 0 && k < 3){
          String testString = "www.google.com"+ schemes[k];
          assertTrue(url.isValid(testString));
       }
       else {
         String testString = "www.google.com" + schemes[k];
         assertFalse(url.isValid(testString));
       }
     }
   }

}
