   $("#home").click(function(e) {
      $.ajax({
        type: "GET",
         url : '',
         data : $('#home').serialize(),
         success : function(res) {
             window.location.href = "/"
         }
      })
   });

function showButtons() {
      $.ajax({
      type: "GET",
         url : 'loginCheck',
         data : $('#myBookmarks').serialize(),
         success : function(res) {
            if(!res) {
                $("#logout").hide();
                $("#myBookmarks").hide();
                $("#myLikes").hide();
                $("#like").hide();
                $("#bookmark").hide();
            } else {
                $("#login").hide();
                $("#register").hide();
            }
         }
      })
}