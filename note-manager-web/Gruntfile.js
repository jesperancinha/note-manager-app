module.exports = function(grunt){

    grunt.loadNpmTasks('grunt-contrib-uglify');

    grunt.initConfig({
      uglify: {
          options: {
              sourceMap: false,
              wrap: 'exports',
              mangle: false
          },
          js: {
              src: ['src/main/webapp/resources/js/addnote.js'],
              dest: 'src/main/webapp/resources/js/addnote.min.js'
          }
       }
    });

    grunt.registerTask('default', ['uglify']);
}
