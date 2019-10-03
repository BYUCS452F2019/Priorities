<template>
  <div class="home">
    <h1>Welcome to Priorities</h1>
    <p>{{msg}}</p>
  </div>
</template>

<script>
// @ is an alias to /src
export default {
  name: 'home',
  data: function(){
    return {
      msg: ''
      }
  },
  created: function() {
    let vm = this
    this.$http.get('http://127.0.0.1:8081').then(function (response) {
      vm.msg = response.data
    })
  }
}
</script>
