export async function load({ fetch }) {
    let res = await fetch("http://localhost:8080/api/v1/articles")
    let result = await res.json()
    return result 
}