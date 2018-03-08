def config = [:]

//backend repo config
config.serviceRepo = 'git@github.com:varunasunmathi/test.git'
config.gitBranch = 'master'
// load the common pipeline definition groovy file script.
def external = fileLoader.fromGit('backend.groovy', 'git@github.com:varunasunmathi/groovypipeline.git', 'master', null, '')
//external.pipeline(params)
external.buildPipeline(config)
