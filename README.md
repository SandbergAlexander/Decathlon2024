#  Hej detta är ett skolarbete 
   Detailed Requirements
1. Scoring System Using the 2001 IAAF Scoring Table
   • Requirement 1.1: The system shall use the 2001 IAAF scoring table to calculate
   points for each event in both decathlon and heptathlon.
   o 1.1.1: Each event (e.g., 100m, long jump, shot put) shall have a dedicated
   class that encapsulates the specific scoring formula provided by the IAAF
   2001 scoring table.
   o 1.1.2: The scoring formula shall be implemented using the parameters A,
   B, and C as per the IAAF scoring table.
   o 1.1.3: The system shall validate that the input results are within the
   acceptable range for each event before calculating the score.
2. Handling Up to 40 Competitors
   • Requirement 2.1: The system shall manage and compute results for up to 40
   competitors.
   o 2.1.1: The competitor information, including name and results for each
   event, shall be stored in an in-memory data structure, such as a list or
   array.
   o 2.1.2: The system shall provide a graphical user interface (GUI) for
   entering the names and results of competitors, allowing input for each
   event.
   o 2.1.3: The system shall ensure that no more than 40 competitors can be
   added.
3. Result Presentation in an Excel File
   • Requirement 3.1: The system shall export the final results of all competitors to
   an Excel file.
   o 3.1.1: The Excel file shall include a sheet with the following columns:
   Competitor Name, Event Names, Individual Event Scores, and Total Score.
   o 3.1.2: The ExcelPrinter class shall handle the creation and formatting of
   the Excel file.
   o 3.1.3: The filename of the Excel file shall include a timestamp or unique
   identifier to avoid overwriting existing files.
   o 3.1.4: The system shall ensure that data in the Excel file is correctly
   aligned and formatted for readability.
4. Real-Time Score Viewing
   • Requirement 4.1: The current scores of competitors shall be viewable at any
   time during the program's execution.
   o 4.1.1: The GUI shall include an option to view the current standings of all
   competitors, showing both individual event scores and total scores.
   o 4.1.2: The system shall update and display scores in real-time as results
   are entered.
   o 4.1.3: The output shall be presented in a tabular format within the GUI,
   allowing easy comparison of scores across all competitors.
5. Program Persistence and Resumption
   • Requirement 5.1: The system shall allow the user to stop the program and
   resume it later, without losing any entered data.
   o 5.1.1: The system shall automatically save the current state (including all
   entered competitor information and scores) to a file when the program is
   stopped.
   o 5.1.2: The program shall offer the option to save the state manually at any
   point during execution.
   o 5.1.3: Upon restarting the program, the system shall load the saved state,
   restoring all competitors, their scores, and any other relevant data.
   o 5.1.4: The system shall handle potential conflicts, such as multiple
   resumption attempts or corrupted save files, by providing appropriate user
   prompts and options.
6. General Usability Requirements
   • Requirement 6.1: The GUI shall be user-friendly, intuitive, and responsive.
   o 6.1.1: All user inputs shall be validated with error messages displayed for
   invalid inputs (e.g., non-numeric data in result fields).
   o 6.1.2: The GUI shall include tooltips or help text to assist users in
   understanding what input is expected.
   o 6.1.3: The GUI design shall ensure that all main functionalities (adding
   results, viewing scores, exporting data) are accessible within a few clicks.