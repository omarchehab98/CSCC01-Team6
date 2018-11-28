function registerEmbedChartPlugin(charts) {
    tinymce.PluginManager.add('embed-chart', function(editor, url) {
        editor.addButton('embed-chart', {
            text: 'Embed Chart',
            icon: false,
            onclick: onEmbedChart
        });

        editor.addMenuItem('embed-chart', {
            text: 'Embed Chart',
            context: 'tools',
            onclick: onEmbedChart,
        });

        function onEmbedChart() {
            editor.windowManager.open({
                title: 'Embed Chart',
                body: [
                    {
                        type: 'listbox',
                        name: 'chart',
                        label: 'Chart',
                        values: charts.map(chart => ({
                            value: chart.id,
                            text: chart.name,
                        }))
                    }
                ],
                onsubmit: function(e) {
                    editor.insertContent(`<iframe
                        src="/charts/${e.data.chart}/embed"
                        style="
                            border: none;
                            display: block;
                            margin: auto;
                            width: 640px;
                            height: 410px;
                        "
                    >`);
                }
            });
        }

        return {
            getMetadata: function () {
                return  {
                    name: "Embed Chart Plugin"
                };
            }
        };
    });
}