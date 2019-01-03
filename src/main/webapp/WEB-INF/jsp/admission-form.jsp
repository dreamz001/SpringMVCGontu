<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h3>${headerMessage}</h3>
<h3>Student Admission Form for Engineering Courses</h3>
<form:errors path="studentObj.*"/>
<form action="submit-admission-form" method="post">
<table>
	<tr>
		<td>Student's Name:</td>
		<td><input type="text" name="studentName"></td>
	</tr>
	<tr>
		<td>Student's Hobby:</td>
		<td><input type="text" name="studentHobby"></td>
	</tr>	
	<tr>
		<td>Student's Mobile:</td>
		<td><input type="text" name="studentMobile"></td>
	</tr>
	<tr>
		<td>Student's DOB:</td>
		<td><input type="text" name="studentDOB"></td>
	</tr>
	<tr>
		<td>Student's Skill Set:</td>
		<td><select name="studentSkills" multiple>
				<option value="Java Core">Java Core</option>
				<option value="Spring Core">Spring Core</option>
				<option value="Spring MVC">Spring MVC</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>Student's Address:</td>
	</tr>
	<tr>
		<td>Street:</td>
		<td><input type="text" name="studentAddress.street"></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><input type="text" name="studentAddress.city"></td>
	</tr>
	<tr>
		<td>Pincode:</td>
		<td><input type="text" name="studentAddress.pincode"></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><input type="text" name="studentAddress.country"></td>
	</tr>
</table>
<input type="submit">
</form>
</body>
</html>
