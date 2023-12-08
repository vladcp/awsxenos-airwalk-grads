def setupPythonEnv(){
    sh script: "python3 -m venv ${env.WORKSPACE}/.venv"
    sh script: [
        "#!/bin/bash",
        "source ${env.WORKSPACE}/.venv/bin/activate",
        "python -m pip install --upgrade pip",
        "pip install tox build"
    ].join("\n")
}
pipeline {
    agent any

    stages {
        stage("Install Dependencies") {
            steps {
                script {
                    setupPythonEnv()
                }
            }
        }
        stage("Run Tests") {
            steps {
                script {
                    sh script: "source ${env.WORKSPACE}/.venv/bin/activate"
                    sh script: "tox -e py"
                }
            }
        }
        stage("Run Build") {
            steps {
                script {
                    sh script: "source ${env.WORKSPACE}/.venv/bin/activate"
                    sh script: "python -m build"
                }
            }
        }
    }
}