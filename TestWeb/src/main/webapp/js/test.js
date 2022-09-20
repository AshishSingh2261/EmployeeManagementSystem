var counter=0;
        $(window).scroll(function () {
            if ($(window).scrollTop() == $(document).height() - $(window).height() && counter < 2) {
                appendData();
            }
        });
        function appendData() {
            var html = '';
            for (i = 0; i < 10; i++) {
                html += '<p class="dynamic">Dynamic Data :  This is test data.<br />Next line.</p>';
            }
            $('#myScroll').append(html);
			counter++;
			
			if(counter==2)
			$('#myScroll').append('<button id="uniqueButton" style="margin-left: 50%; background-color: powderblue;">Click</button><br /><br />');
        }