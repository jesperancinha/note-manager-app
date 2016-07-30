module.exports = function(grunt){
    pkg: grunt.file.readJSON('package.json'),

    grunt.loadNpmTasks('grunt-package-modules');

    grunt.initConfig({
      packageModules: {
        dist: {
          src: 'package.json',
          dest: 'src/main/webapp'
        },
      },
    });

    grunt.registerTask('default', ['packageModules']);
}
