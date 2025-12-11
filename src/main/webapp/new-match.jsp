<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tennis Scoreboard | New Match</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<header class="header">
    <section class="nav-header">
        <div class="brand">
            <div class="nav-toggle">

            </div>
            <span class="logo-text">TennisScoreboard</span>
        </div>
        <div>
            <nav class="nav-links">
                <a class="nav-link" href="<c:url value='/home.jsp'/>">Home</a>
                <a class="nav-link" href="<c:url value='/'/>">Matches</a>
            </nav>
        </div>
    </section>
</header>
<main>
    <div class="container">
        <div>
            <h1>Start new match</h1>
            <div class="new-match-image"></div>
            <div class="form-container center">
                <form>

                    <label class="label-player" for="playerOne">Player one</label>
                    <input id="playerOne" class="input-player" name="playerOne" placeholder="Name" type="text" required title="Enter a name">

                    <label class="label-player" for="playerTwo">Player two</label>
                    <input id="playerTwo" class="input-player" name="playerTwo" placeholder="Name" type="text" required title="Enter a name">

                    <input id="start_match_btn" class="form-button" type="submit" value="Start">
                </form>
            </div>
        </div>
    </div>
</main>
<footer>
    <div class="footer">
        <p>&copy; Tennis Scoreboard, project from
            <a href="https://zhukovsd.github.io/java-backend-learning-course/">zhukovsd/java-backend-learning-course</a> roadmap.
        </p>
    </div>
</footer>
<script src="<c:url value='/js/app.js'/>"></script>
</body>
</html>
