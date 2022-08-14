(function() {
    $.ajax({
        url: '${pageContext.request.contextPath}/user/AllUser',
        type: 'get',
        // data: {},
        dataType: 'json',
        success: function(data) {
            let res = data;

            for(let user of res){
                console.log(user.username);
            }
        }
    });

})();
