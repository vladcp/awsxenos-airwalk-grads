pipeline {
    agent any

    stages {
        stage("Install Dependencies") {
            steps {
                script {
                    sh script: "python3 -m venv ${env.WORKSPACE}/.venv"
                    sh script: [
                        "#!/bin/bash",
                        "source ${env.WORKSPACE}/.venv/bin/activate",
                        "python -m pip install --upgrade pip",
                        "pip install tox build"
                    ].join("\n")
                }
            }
        }
        stage("Run Tests") {
            steps {
                script {
                    sh script: [
                        "#!/bin/bash",
                        "source ${env.WORKSPACE}/.venv/bin/activate",
                        "tox -e py"
                    ].join("\n")
                }
            }
        }
        stage("Run Build") {
            steps {
                script {
                    sh script: [
                        "#!/bin/bash",
                        "source ${env.WORKSPACE}/.venv/bin/activate",
                        "python -m build"
                    ].join("\n")
                }
            }
        }
    }
}