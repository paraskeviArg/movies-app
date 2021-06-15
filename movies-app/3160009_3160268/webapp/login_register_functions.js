 /*  Submit form using Ajax */
   $("#register").click(function(e) {
      $.ajax({
        type: "GET",
         url : '',
         data : $('#register').serialize(),
         success : function(res) {
             window.location.href = "register"
         }
      })
   });


   $("#login").click(function(e) {
      $.ajax({
        type: "GET",
         url : '',
         data : $('#login').serialize(),
         success : function(res) {
             window.location.href = "login"
         }
      })
   });
   $("#logout").click(function(e) {
      $.ajax({
        type: "GET",
         url : '',
         data : $('#logout').serialize(),
         error: function (request, status, error) {
              window.location.href = "logout"
         },
         success : function(res) {
             window.location.href = "logout"
         }
      })
   });
$("#rform").submit(function( e ) {
    //Prevent default submission of form
          e.preventDefault();
          $.ajax({
            type: "GET",
             url : '/register',
             data : $("#rform").serialize(),
             error: function (request, status, error) {
                    if(request.status==400) {
                     alert("Email already in use.")
                     }
              },
             success : function(res) {
                 alert("Registration complete.")
                 window.location.href = '/'
             }
          })
   });
   $("#lform").submit(function( e ) {
    //Prevent default submission of form
          e.preventDefault();
         $.ajax({
                 type: "GET",
                  url : '/login',
                  data : $("lform").serialize(),
                  error: function (request, status, error) {
                         if(request.status==401) {
                          alert("Wrong email or password.")
                          } else if(request.status==402) {
                          alert("SQL Error.")
                          }
                   },
                  success : function(res) {
                      window.location.href = '/'
                  }
               })
   });