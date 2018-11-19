Vue.component('input-datalist', {
    props: {
        id: String,
        getCount: Function,
        getName: Function,
        getValue: Function,
    },

    template: `
        <datalist v-bind:id="id">
            <option
                v-for="index in getCount()"
                v-bind:value="getName(index - 1)"
            >
                {{ getValue(index - 1) }}
            </option>
        </datalist>
    `,
});
