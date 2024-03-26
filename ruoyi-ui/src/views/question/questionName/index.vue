<template>
  <div>
    <button @click="lookType">接口</button>
  </div>
</template>

<script>
import getType from "../../../utils/getType";
export default {
  name: "",

  data() {
    return {
      queryParams: {
        typeName: "",
        remark: "",
      },
    };
  },
  methods: {
    lookType() {
      getType(this.queryParams).then((res) => {
        for (let i = 0; i < res.rows.length; i++) {
          console.log(res.rows[i].typeName);
        }
      });
    },
  },
};
</script>

<style>
</style>