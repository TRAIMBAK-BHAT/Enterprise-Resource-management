export async function fetchAssets() {
  const response = await fetch("http://139.59.15.97:8080/assets");
  return response.json();
}
