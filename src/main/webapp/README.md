# Take: front
## 开发中遇到的问题
1. 在使用`webpack-dev-server`时, 如果使用`BrowserRouter`作为路由, 在当前路由下自动刷新时导致`404`
2. `hook`在组件未渲染时不执行
3. 前后端不分离
    * 在前端开启`webpack-dev-server`后, 需要在`output`中指定`publicPath`才可以访问到编译在内存中的静态文件
    * `publicPath`在本项目中为`/dist/`