
package com.bits.mvn;



import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;



public class App {

    private static Logger logger = LogManager.getLogger(App.class);

    // Unused variable (Task 3 requirement)

    private String name = "Hello"; 



    public String greet(String name) {

        return "hello " + name + "!";

    }



    public static void main(String[] args) {

        App app = new App();

        

        // This line causes a "Divide by Zero" error (Task 3 requirement)

        // We wrap it in try-catch so it doesn't crash your build immediately, 

        // but SonarQube will still detect the bug.

        try {

            logger.debug(3/0);

        } catch (Exception e) {

           // ignore

        }



        // Conditional always true (Task 3 requirement)

        if (true) {

            if(args.length > 0) {

                logger.info(app.greet(args[0]));

            }

        }

    }

}

