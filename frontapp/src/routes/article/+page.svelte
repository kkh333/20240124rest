<script>
    export let data
    console.log(data)
</script>
<div>게시글 목록</div>
<ul>
    {#each data.data.articles as article}
    <li>
        <a href="/article/{article.id}">
            {article.subject}   
        </a>
    </li>
    {/each}
</ul>
