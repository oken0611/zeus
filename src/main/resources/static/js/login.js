$(function() {
    setInterval(reload,5000);
});

// ログインページを表示したまま、
// セッションタイムアウト時間を経過するとログインに失敗する
// ログインページを定期的にリロードする
const reload = function(){
    console.log('start')
    axios.get('/zeus/login').then(res => console.log(res.data))
    console.log('end')
}