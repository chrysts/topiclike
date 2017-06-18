var gulp = require('gulp'), 
	browserify = require('browserify'),
	babelify = require('babelify'),
	uglify = require('gulp-uglify'),
	rename = require('gulp-rename'),
	source = require('vinyl-source-stream'),
	package = require('./package.json');

function js(sourceFile, destDir, destFile) {
	return browserify(sourceFile)
	.transform(babelify, {presets: ['react']})
	.bundle()
	.pipe(source(destFile))
	.pipe(gulp.dest(destDir));
}

function jsMin(sourceFile, destDir, destFile) {
	return browserify(sourceFile)
	.transform(babelify, {presets: ['react']})
	.bundle()
	.pipe(source(destFile))
	.pipe(buffer())
	.pipe(uglify())
	.pipe(gulp.dest(destDir));
}

function compileJs(minify) {
	var paths = package.paths.jsx;
	var i, len = paths.files.length;

	var sourceDir = paths.sourceDir;
	var destDir = paths.destDir;

	for (i = 0; i < len; i++) {
		if (minify) {
			jsMin(sourceDir + paths.files[i].source, destDir, paths.files[i].dest);
		} else {
			js(sourceDir + paths.files[i].source, destDir, paths.files[i].dest);
		}
	}
}


gulp.task('js', function() {
	compileJs();
});

gulp.task('js:min', function() {
	compileJs(true);
});

gulp.task('default', ['js'], function() {});