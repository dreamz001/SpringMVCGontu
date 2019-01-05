<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<link rel="styleSheet" type="text/css" href="<spring:theme code='styleSheet'/>"/>
</head>
<body>
<a href="admission-form?siteTheme=red" >Red</a> | 
<a href="admission-form?siteTheme=green" >Green</a>
<br/>
<a href="admission-form?siteLanguage=en" >English</a> | 
<a href="admission-form?siteLanguage=fr" >French</a>
<h3>${headerMessage}</h3>
<h3><spring:message code="label.admissionMessage"/></h3>
<form:errors path="studentObj.*"/>
<form action="submit-admission-form" method="post">
<table>
	<tr>
		<td><spring:message code="label.studentName"/></td>
		<td><input type="text" name="studentName"></td>
	</tr>
	<tr>
		<td><spring:message code="label.studentHobby"/></td>
		<td><input type="text" name="studentHobby"></td>
	</tr>	
	<tr>
		<td><spring:message code="label.studentMobile"/></td>
		<td><input type="text" name="studentMobile"></td>
	</tr>
	<tr>
		<td><spring:message code="label.studentDOB"/></td>
		<td><input type="text" name="studentDOB"></td>
	</tr>
	<tr>
		<td><spring:message code="label.studentSkills"/></td>
		<td><select name="studentSkills" multiple>
				<option value="Java Core">Java Core</option>
				<option value="Spring Core">Spring Core</option>
				<option value="Spring MVC">Spring MVC</option>
			</select>
		</td>
	</tr>
	<tr>
		<td><spring:message code="label.studentAddress"/></td>
	</tr>
	<tr>
		<td><spring:message code="label.street"/></td>
		<td><input type="text" name="studentAddress.street"></td>
	</tr>
	<tr>
		<td><spring:message code="label.city"/></td>
		<td><input type="text" name="studentAddress.city"></td>
	</tr>
	<tr>
		<td><spring:message code="label.pincode"/></td>
		<td><input type="text" name="studentAddress.pincode"></td>
	</tr>
	<tr>
		<td><spring:message code="label.country"/></td>
		<td><input type="text" name="studentAddress.country"></td>
	</tr>
</table>
<input type="submit" value="<spring:message code='label.submit'/>">
</form>
</body>
</html>
