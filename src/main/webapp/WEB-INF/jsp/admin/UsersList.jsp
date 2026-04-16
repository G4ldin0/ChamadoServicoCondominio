<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Moradores</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }

        .page-container { max-width: 1200px; margin: 0 auto; }

        .header {
            background: white;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
            margin-bottom: 24px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .user-info { display: flex; flex-direction: column; gap: 5px; }

        .user-info h2 { color: #333; font-size: 20px; margin-bottom: 5px; }

        .user-info p { color: #666; font-size: 14px; }

        .user-info .role {
            display: inline-block;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 4px 12px;
            border-radius: 20px;
            font-size: 12px;
            font-weight: 600;
            margin-top: 5px;
            width: fit-content;
        }

        .logout-btn {
            background: #ff6b6b;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-weight: 600;
        }

        .logout-btn:hover { background: #ff5252; }

        .container {
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
        }

        h1 { color: #333; margin-bottom: 20px; }

        .back-btn {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            margin-bottom: 20px;
        }

        .back-btn:hover { opacity: 0.9; }

        .create-form {
            margin-bottom: 28px;
            padding: 20px;
            border: 1px solid #e9e9e9;
            border-radius: 10px;
            background: #fafafa;
        }

        .create-form h2 { color: #333; font-size: 20px; margin-bottom: 16px; }

        .form-row {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
            gap: 12px;
            margin-bottom: 12px;
        }

        .create-form input {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #d8d8d8;
            border-radius: 6px;
            font-size: 14px;
        }

        .create-form input:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 0 2px rgba(102, 126, 234, 0.15);
        }

        .submit-btn {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: #fff;
            border: none;
            padding: 10px 18px;
            border-radius: 6px;
            cursor: pointer;
            font-weight: 600;
        }

        .submit-btn:hover { opacity: 0.95; }

        .users-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 24px;
        }

        .users-table thead {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
        }

        .users-table th {
            padding: 12px;
            text-align: left;
            font-weight: 600;
        }

        .users-table tbody tr {
            border-bottom: 1px solid #e9e9e9;
            transition: background-color 0.2s;
        }

        .users-table tbody tr:hover {
            background-color: #f5f5f5;
        }

        .users-table td {
            padding: 12px;
            color: #333;
        }

        .users-table .role-badge {
            display: inline-block;
            background: #667eea;
            color: white;
            padding: 4px 10px;
            border-radius: 12px;
            font-size: 12px;
            font-weight: 600;
        }

        .empty-message {
            text-align: center;
            color: #999;
            padding: 30px;
            font-style: italic;
        }

        .action-link {
            text-decoration: none;
            cursor: pointer;
            margin-right: 10px;
        }

        .action-link.edit { color: #667eea; }
        .action-link.delete { color: #ff6b6b; }

        .action-link:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <div class="page-container">
        <%@ include file="/WEB-INF/jsp/admin/fragments/adminHeader.jspf" %>

        <div class="container">
            <a href="${pageContext.request.contextPath}/admin/home" class="back-btn">&larr; Voltar</a>

            <form class="create-form" method="POST" action="${pageContext.request.contextPath}/admin/moradores">
                <h2>Novo Morador</h2>
                <div class="form-row">
                    <input type="text" name="name" placeholder="Nome completo" required>
                    <input type="text" name="login" placeholder="Login" required>
                    <input type="password" name="password" placeholder="Senha" required>
                </div>
                <button type="submit" class="submit-btn">Cadastrar morador</button>
            </form>

            <h1>Gerenciar Moradores</h1>

            <c:choose>
                <c:when test="${empty userList}">
                    <div class="empty-message">Nenhum morador cadastrado no sistema.</div>
                </c:when>
                <c:otherwise>
                    <table class="users-table">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Login</th>
                                <th>Role</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${userList}">
                                <tr>
                                    <td>${user.name}</td>
                                    <td>${user.login}</td>
                                    <td><span class="role-badge">${user.role}</span></td>
                                    <td>
                                        <a href="#" class="action-link edit">Editar</a>
                                        <form style="display: inline;" method="POST" action="${pageContext.request.contextPath}/admin/moradores/apagar/${user.id}">
                                            <button type="submit" class="action-link delete" style="background: none; border: none; padding: 0; font-size: inherit;">Deletar</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</body>

</html>
