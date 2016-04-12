# HR_Management
Individual Project

Configuration instructions
Coding Environment: Mac OS X, Eclipse 4.5, Java Version "1.8.0_20"

Installation instructions
1.Copy the hr_management.jar to computer.
2.Install JAVA runtime in the computer.
3.Then run the jar file.

Operating instructions
1.Add Employee: Click the "Add Employee" button and input the employee ID and name, then choose whether this employee is director(Can only create one director.) and click the "submit" button.
2.Delete Employee: Click the "Delete Employee" button and input the ID of employee which you want to delete, then click "delete" button.
3.Check Holiday Status: Click the "Check Holiday Status" button and input the ID of employee which you want to check. It will show the holiday request result.
4.Apply For leave: Click the "Apply For Leave" button and input employee ID, then choose start date and end date, finally, click the "Apply" button.
5.Assign Supervisor: Click the "Assign Supervisor" button and input "ID" and "Supervisor ID". Then the employee whose ID is "Supervisor ID" will be the supervisor of the one whose ID is "ID".
6.Process Request: Click the "Process Request" button and input the supervisor ID, then you can see the notice of those whose supervisor is him applying the leave. Then you can choose one to click "endorse" button to approve the request, or you can also click "decline" button to reject it.
7.Display Employee: Click the "Display Employee" button and it will display all the employee information you create.

Design pattern instructions
Use of chain-of-responsibility design pattern: Every employee is processing object, and every holiday request is commanding object. The supervisor(employee) can choose endorse or decline the request. For every supervisor(employee), if he/she chooses endorse, the system will check whether he/she have a supervisor, if yes, the request will be sent to next supervisor;if no, the request will feed back to the requester. On the contrary， if he/she chooses decline, the system will send the feed back directly to the requester.
