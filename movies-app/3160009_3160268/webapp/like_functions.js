
   $("#like").click(function(e) {
       $.ajax({
        type: "POST",
              contentType : 'application/json; charset=utf-8',
         url : 'like',
         data : JSON.stringify(sessionStorage.getItem('movieID')),
         error: function (request, status, error) {
                if(request.status==403) {
                  alert("Like already added.")
                  }
          },
         success : function(res) {
                  location.reload();
            alert("Movie added to your likes list")
         }
      })
   });
    $("#myLikes").click(function(e) {
         $.ajax({
         type: "GET",
            url : '',
            data : $('#myLikes').serialize(),
            success : function(res) {
               window.location.href = "my_likes"
            }
         })
      });

