var data = {};
var serverData = document.querySelectorAll("script[type='application/json']");
for (var jsonElement of serverData) {
    try {
        data[jsonElement.dataset.key] = JSON.parse(jsonElement.innerText);
    } catch (err) {
        console.error('json-loader: Failed to load JSON data with key "' + jsonElement.dataset.key + '"');
        console.error(err);
        data[jsonElement.dataset.key] = null;
    }
}
