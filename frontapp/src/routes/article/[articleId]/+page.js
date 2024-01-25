export async function load({ fetch, params }) {
    let res = await fetch("http://localhost:8080/api/v1/articles/" + params.articleId)
    let result = await res.json()

    return result
}