let timeout = null;
$(document).ready(() => {  //document ready kai prevent default
 $('#searchBar').on('keyup', (e) =>  {
    clearTimeout(timeout);
   timeout = setTimeout(function () {
    let sText = ($('#searchText').val());
    getMovies(sText);
}, 500);
     e.preventDefault();
 });
});
function getMovies(sText){
  $.ajax({
    type: "GET",
    url: 'http://www.omdbapi.com/?s=' + sText + '&apikey=a096fafc', //to request apo jquery edw
      data :Object,
    success :function(res){
       console.log(res);
      let movies = res.Search;  //pernaw ton pinaka se variable
      let output = '';
      console.log(movies);
      if(res.Error=='Movie not found!'){ // ta ekana etsi giati to jQuery get den pairnei fail function kai den douleuan ta alla
			$("#movies").html('Error no movies found!');
      }else if(res.Error == 'Too many results.'){
		  $("#movies").html('Too many results, please type more.');
      }else{
      var i;
      for(i=0;i<movies.length;i++){
        movie(movies[i].imdbID);
      }
    }
     }
  })
}

let output = '';
function movie(x){// auto einai gia to plot
  $.ajax({
    type: "GET",
    url: 'http://www.omdbapi.com/?i=' + x + '&apikey=a096fafc', //to request apo jquery edw
    data:Object,
    success : function(y){
      console.log(y);
       output += `
          <div id='los' style="border: 1px solid black;text-align:center;">
            <h3>${y.Title}</h3>
            <img src="${y.Poster}">
            <h5>Plot :${y.Plot}</h5>
            <a onclick="selectMovie('${y.imdbID}')" href="#">Learn More</a><br>
          </div>
        `;
      $("#movies").html(output);
      }
    });
    output = '';
  }

function selectMovie(id){ //pairnw to id gia na kanw redirect se allo page
  sessionStorage.setItem('movieID',id); //pairnw to id
  window.location='/movie.jsp';  //kanw redirect
  return false;
}

function movieDet(){ //ekteleite me to pou phgainoume se neo page
  let movieID = sessionStorage.getItem('movieID');
  $.ajax({
    type: "GET",
    url: 'http://www.omdbapi.com/?i=' + movieID + '&apikey=a096fafc', //to request apo jquery edw
    success :function(res){
      console.log(res);
      let output = '';
      output += `
          <div>
            <h2>${res.Title}</h2>
            <img src="${res.Poster}">
            <ul>
              <li>Genre: ${res.Genre}</li>
              <li>Year: ${res.Year}</li>
              <li>Plot: ${res.Plot}</li>
              <li>Director: ${res.Director}</li>
              <li>Rated: ${res.Rated}</li>
            </ul>
          </div>
          <hr>
          <a href="http://imdb.com/title/${res.imdbID}/" target="_blank">Go to IMDB</a>
        `; //to target apo panw einai gia na anoigei allo page gia to imdb
        $("#movie").html(output);
    }
  });
}
