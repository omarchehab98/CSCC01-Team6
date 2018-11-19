Vue.component('input-ordered-select', {
    props: {
        name: String,
        values: Array,
        push: Function,
        pop: Function,
        getCount: Function,
        getName: Function,
        getValue: Function,
    },

    template: `
        <div>
            <div v-for="value in values">
                <input-select
                    v-bind="{
                        name,
                        value,
                        getCount,
                        getName,
                        getValue,
                    }"
                >
                </input-select>
            </div>

            <div class="m-top-3">
                <button
                    class="btn btn-secondary btn-sm m-right-3"
                    v-on:click="push"
                    type="button"
                >
                    Add
                </button>

                <button
                    class="btn btn-secondary btn-sm m-right-3"
                    v-on:click="pop"
                    v-if="values.length > 0"
                    type="button"
                >
                    Remove
                </button>
            </div>
        </div>
    `,
});
