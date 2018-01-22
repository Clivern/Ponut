var Encore = require('@symfony/webpack-encore');

Encore
    .setOutputPath('public/build/')
    .setPublicPath('/build')
    .cleanupOutputBeforeBuild()
    .enableVersioning(true)
    .addEntry('js/app', './public/assets/javascripts/app.js')
    .addStyleEntry('css/app', ['./public/assets/stylesheets/app.css'])
;

module.exports = Encore.getWebpackConfig();