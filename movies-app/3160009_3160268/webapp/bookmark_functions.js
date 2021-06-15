   $("#bookmark").click(function(e) {
       $.ajax({
        type: "POST",
              contentType : 'application/json; charset=utf-8',
         url : 'bookmark',
         data : JSON.stringify(sessionStorage.getItem('movieID')),
         error: function (request, status, error) {
                if(request.status==403) {
                  alert("Bookmark already added.")
                  }
          },
         success : function(res) {
         location.reload();
            alert("Movie added to your bookmarks list")

         }
      })
   });
 $("#myBookmarks").click(function(e) {
      $.ajax({
      type: "GET",
         url : '',
         data : $('#myBookmarks').serialize(),
         success : function(res) {
            window.location.href = "my_bookmarks"
         }
      })
   });
   $("#delete_bookmark").click(function(e) {
       $.ajax({
        type: "POST",
              contentType : 'application/json; charset=utf-8',
         url : 'delete_bookmark',
         data : JSON.stringify(sessionStorage.getItem('movieID')),
         success : function(res) {
         location.reload();
            alert("Movie removed from your bookmarks list.")

         }
      })
   });
