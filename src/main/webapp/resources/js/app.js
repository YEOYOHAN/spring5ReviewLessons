var app = app || {}
app = (() => {
    const WHEN_ERR = '호출하는 js 파일을 찾을 수 없습니다.';
    let _, js
    let run = x => $.getScript(x + '/resources/js/router.js',
        () => {
            $.extend(new Session(x));
            onCreate()
        });
    let init = () => {
        _ = sessionStorage.getItem('ctx')
        js = sessionStorage.getItem('js')
    }
    let onCreate = () => {
        init()
        setContentView()
    }
    let setContentView = () => {
        $('<table id="tab"><tr></tr></table>').css({
            width: '80%',
            height: '800px',
            border: '1px solid black',
            margin: '0 auto'
        }).appendTo('#war')
        $('<td/>', {
            id: 'left'
        }).css({
            width: '20%',
            height: '100%',
            border: '1px solid black',
            'vertical-align': 'top'
        }).appendTo('tr')
        $('<td/>', {
            id: 'right'
        }).css({
            width: '80%',
            height: '100%',
            border: '1px solid black',
            'text-align': 'center'
        }).appendTo('tr')
        $.each(['NAVER', 'CGV', 'BUGS'], (i, j) => {
            $('<div/>')
                .text(j)
                .css({
                    width: '100%',
                    height: '50px',
                    border: '1px solid red',
                    'text-align-last': 'center'
                }).appendTo('#left').click(function() {
                    $(this).css({
                        'background-color': 'yellow'
                    })
                    $(this).siblings().css({
                        'background-color': 'white'
                    });
                    _ = sessionStorage.getItem('ctx')
                    switch ($(this).text()) {
                        case 'NAVER':
                            $.getJSON(_ + '/roro/naver', d => {
                            	$('#right').empty()
                                $.each(d, (i, j) => {
                                    $('<div/>').css({
                                        width: '49%',
                                        height: '49%',
                                        border: '3px solid red',
                                        float: 'left'
                                    }).html('<h1>' + j.origin + '</h1><h4>' + j.trans + '</h4>').appendTo('#right')
                                })
                            })
                            break;
                        case 'CGV':
                            $.getJSON(_ + '/roro/cgv', d => {
                            	$('#right').empty()
                                $.each(d, (i, j) => {
                                    $('<div><img style="width:200px;" src="' + j.image + '"/><br/>' + j.title + '<br/>' + j.percent + '<br/>' + j.info + '</div>')
                                    .css({
                                        border: '3px solid red',
                                        float: 'left'
                                    }).appendTo('#right')
                                })
                            })
                            break;
                        case 'BUGS':
        					$.getJSON(_+'/roro/bugs',d=>{
        						let pagep = d.pagep;
        						let list = d.list;
        						$('#right').empty()
        						$('<table id="content"><tr id="head"></tr></table>')
        						.css({width: '99%',
        								height: '50px',
        				              border: '1px solid black'})
        						.appendTo('#right')
        						$.each(['No.','앨범','제목','가수'],(i, j)=>{
        							$('<th/>')
        							.html('<b>'+j+'</b>')
        							.css({width: '25%',height: '100%',
        					              border: '1px solid #1E90FF'})
        							.appendTo('#head')
        						})
        						$.each(list,(i, j)=>{
        							$('<tr><td>'+(j.seq)+'</td><td><img src="'+j.thumbnail+'"></td><td>'+j.title+'</td><td>'+j.artist+'</td></tr>')
        							.css({width: '25%',height: '100%',
        					              border: '1px solid #1E90FF'})
        							.appendTo('#content tbody')
        						})
        						$('#content tr td').css({border: '1px solid #1E90FF'})
        						let i = 0
        						for (i = pagep.startPage; i <= pagep.endPage; i++){
        							$('<div class="grid_item">'+(i+1)+'</div>').css({
            							width: '50px',height: '50px',
      					              border: '1px solid #C73399'
            						}).appendTo('#right')
        						}
        						alert('벅스 사이즈 '+d)
        					})
        					break
                    }
                })
        })
    }
    return {
        run
    }
})()