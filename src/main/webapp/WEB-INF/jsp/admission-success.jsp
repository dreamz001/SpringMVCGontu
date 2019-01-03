<html>
<body>
<h2>${headerMessage}</h2>
<h3>Congratulations!!! The Engineering college has processed your Application form successfully</h3>
<h3>Details submitted by you:</h3>
<table>
	<tr>
		<td>Student's Name:</td>
		<td>${studentObj.studentName}</td>
	</tr>
	<tr>
		<td>Student's Hobby:</td>
		<td>${studentObj.studentHobby}</td>
	</tr>	
	<tr>
		<td>Student's Mobile:</td>
		<td>${studentObj.studentMobile}</td>
	</tr>
	<tr>
		<td>Student's DOB:</td>
		<td>${studentObj.studentDOB}</td>
	</tr>
	<tr>
		<td>Student's Skill Set:</td>
		<td>${studentObj.studentSkills}</td>
	</tr>
	<tr>
		<td>Student's Address:</td>
		<td>Street : ${studentObj.studentAddress.street}, City : ${studentObj.studentAddress.city}, Pincode : ${studentObj.studentAddress.pincode},Country : ${studentObj.studentAddress.country}</td>
	</tr>
</table>
</body>
</html>
