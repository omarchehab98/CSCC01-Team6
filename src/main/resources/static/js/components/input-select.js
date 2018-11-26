Vue.component('input-select', {
    props: {
        name: String,
        value: Object,
        getCount: Function,
        getName: Function,
        getValue: Function,
    },

    template: `
        <select
            v-bind:name="name"
            class="m-bottom-3"
            v-model="value.value"
        >
            <option
                v-for="index in getCount()"
                v-bind:value="getName(index - 1)"
            >
                {{ getValue(index - 1) }}
            </option>
        </select>
    `,
});
