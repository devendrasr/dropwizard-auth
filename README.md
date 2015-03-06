# dropwizard-auth
A sample dropwizard application to demonstrate BASIC AUTHENTICATION

##RUN
STEP-1. Goto dropwizard-auth directory
STEP-2. mvn clean package
STEP-3. java -jar target/auth.jar server target/classes/auth.jar
STEP-4. Open REST client and HIT: http://localhost:8080/api/auth/login as POST with below payload:
{
"username":"test",
"password":"test"
}
STEP-5. Grab the token from the response.
STEP-6. HIT: http://localhost:8080/api/auth/greeting/<yourname> as GET with below header:
HEADERNAME---> Authorization and HEADERVALUE---> Basic <token from login response>

If you see a response as : Hey <yourname> :) It means all izz well.

Happy Coding!
