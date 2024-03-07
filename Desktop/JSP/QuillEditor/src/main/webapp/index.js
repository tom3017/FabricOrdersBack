var toolbarOptions = [
    ['bold', 'italic', 'underline', 'strike'],
    ['blockquote', 'code-block'],
    [{ 'header': [1, 2, 3, 4, 5, 6, false] }],
    [{ 'list': 'ordered' }, { 'list': 'bullet' }],
    [{ 'script': 'sub' }, { 'script': 'super' }],
    [{ 'direction': 'rt1' }],
    [{ 'size': ['samll', false, 'large', 'huge'] }],
    [{ 'color': [] }, { 'background': [] }],
    [{ 'font': [] }],
];

var quill = new Quill('#editor', {
    modules: {
        toolbar: toolbarOptions
    },
    theme: 'snow'
});

$('#savedelta').click(function () {
    var delta = quill.getContents();

    // Ajax로 데이터 전송
    $.ajax({
        type: 'POST',
        url: 'your_backend_url', // 백엔드 URL을 적절히 수정하세요
        data: { delta: JSON.stringify(delta) },
        success: function (response) {
            // 성공 시 수행할 동작
            console.log('Data saved successfully:', response);
        },
        error: function (error) {
            // 오류 시 수행할 동작
            console.error('Error saving data:', error);
        }
    });
});
