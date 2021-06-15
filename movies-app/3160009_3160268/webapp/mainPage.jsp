<!DOCTYPE html>
<html lang='en'>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>moviesApp</title>
    </head>
    <body class="container">
	<div id='main'>
             <button type="button" id="logout">Logout </button>
             <button type="button" id="myBookmarks">My Bookmarks </button>
             <button type="button" id="myLikes">My Likes </button>
             <button class='button' type="button" id="login">Login </button>
             <button class='button' type="button" id="register">Register </button>
        <h1>Movie search:</h1>
        <div id = 'searchWrap'>
            <form id = 'searchBar'>
                <input type="text" id="searchText" placeholder="Search for title.." title="Type in a movie title">
            </form>
        </div>
        <div>
            <div id="movies" class="row">
            </div>
            <div id='here' class='row1'></div>
        </div>
        <script
            src="https://code.jquery.com/jquery-3.5.1.min.js"
            integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
            crossorigin="anonymous">
        </script>
        <script src='search_movie_functions.js'></script>
         <script src='login_register_functions.js'></script>
                          <script src='like_functions.js'></script>
                           <script src='bookmark_functions.js'></script>
         <script src='generic_functions.js'></script>
        <script>
        showButtons();
         </script>
        </div>
        <footer>
				Created by:
                Paris Miglis - 3160268 & Paraskevi Argyroudaki - 3160009
        </footer>
    </body>
</html>