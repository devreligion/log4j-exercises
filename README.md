# Logging exercise

1. Add log4j dependency
2. Replace all System.out and System.error usage. System.out => logger.info, System.error => logger.error 
3. Add log4j.xml configuration which meet requirements
4. Improve app performance by adding asynch appender for Producer and Consumer messages



#### Requirements
1. Main class messages are logged only to console.
2. Producer and Consumer messages are logged only to app.log file
3. All errors are logged to error.log file