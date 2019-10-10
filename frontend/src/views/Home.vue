<template>
  <div class="home">
    <h1>Welcome to Priorities</h1>
    <p v-if="loggedIn">Please <a href="/#/login">login</a></p>
    <p v-else>Please <a href="/#/register">Regsiter</a></p>
  </div>
</template>

<script>
export default {
  name: 'home',
  data: function () {
    return {
      msg: '',
      loggedIn: false,
      }
  },
  created: function () {
    let vm = this
    this.$http.get('http://127.0.0.1:8081').then(function (response) {
      vm.msg = response.data
    })
  }
}
</script>
