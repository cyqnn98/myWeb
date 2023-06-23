<template>
  <el-row class="mb-4">
    <el-button>Default</el-button>
    <el-button type="primary">Primary</el-button>
    <el-button type="success">Success</el-button>
    <el-button type="info">Info</el-button>
    <el-button type="warning">Warning</el-button>
    <el-button type="danger">Danger</el-button>
  </el-row>
</template>

<script>
const axios = require('axios');
axios.get('http://localhost:8080/api/products/1')
  .then(function (response) {
    // handle success
    console.log(response);
  })
  .catch(function (error) {
    // handle error
    console.log(error);
  })
  .finally(function () {
    // always executed
  });

import {
  // Check,
  // Delete,
  // Edit,
  // Message,
  // Search,
  // Star,
} from '@element-plus/icons-vue'
export default {
    name: 'HomePage',
    components:{
        // Check,
        // Delete,
        // Edit,
        // Message,
        // Search,
        // Star
    }
    // props: {
    //   msg: String
    // }
}
</script>
