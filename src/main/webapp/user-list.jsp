<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>JMV</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-100">

	<div class="text-center py-8">
		<h1 class="text-3xl font-bold text-blue-600">User Management</h1>
		<div class="mt-4">
			<a href="new"
				class="inline-block px-4 py-2 text-white bg-green-500 rounded">Add
				New User</a> <a href="list"
				class="inline-block px-4 py-2 text-white bg-blue-500 rounded ml-2">List
				All Users</a>
		</div>
	</div>

	<div class="max-w-2xl mx-auto bg-white p-8 shadow-md rounded-md mt-8">
		<table class="w-full border border-collapse border-gray-300">
			<caption class="text-lg font-bold mb-4">List of Users</caption>
			<thead>
				<tr>
					<th class="border p-2">ID</th>
					<th class="border p-2">First Name</th>
					<th class="border p-2">Last Name</th>
					<th class="border p-2">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${listUser}">
					<tr>
						<td class="border p-2"><c:out value="${user.id}" /></td>
						<td class="border p-2"><c:out value="${user.firstName}" /></td>
						<td class="border p-2"><c:out value="${user.lastName}" /></td>
						<td class="border p-2"><a
							href="edit?id=<c:out value='${user.id}' />"
							class="text-blue-500 hover:underline">Edit</a> <span class="mx-2">|</span>
							<a href="delete?id=<c:out value='${user.id}' />"
							class="text-red-500 hover:underline">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
