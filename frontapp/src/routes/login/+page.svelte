<script>
    function submitLoginForm () {
        const form = this;

        fetch("http://localhost:8080/user/login", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: form.username.value,
                password: form.password.value
            })
        })
        .then(res => res.json())
        .then(data => console.log(data))
    }
</script>

<form on:submit|preventDefault={submitLoginForm}>
    <input type="text" name="username">
    <input type="password" name="password">
    <button type="submit">전송</button>
</form>