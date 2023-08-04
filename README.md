# Example code for duplication issue of health-checks

This is an example project to demonstrate the behavior described in https://github.com/quarkusio/quarkus/issues/32800.

## Tools you'll need

- kubectl (https://kubernetes.io/docs/tasks/tools/)
- docker (https://docs.docker.com/engine/install)
- k3d (https://k3d.io)

## What is the problem?

The health check behaves just fine when using `./mvnw quarkus:dev`
and when running the application in a docker container.

It behaves strangely only when deployed on a cluster.

The health check seems to duplicate the checks.
This is no duplication in logging but rather a duplication in calling the check twice
(see [comment in issue](https://github.com/quarkusio/quarkus/issues/32800#issuecomment-1593879727)).

## See the problem in action with this example.

Run `./start` script.

This script will set up a local k8s cluster, build the application containing the example
and will deploy the application to your local cluster.

Once everything is up and running, visit `http://localhost:18080/q/health`.

You can see the duplication in checks.

To see the difference to dev-mode, do the following:
- start `./mvnw quarkus:dev`
- open `http://localhost:8080/q/health`

## Clean up.

Once you don't want your example to run anymore, run `./cleanup` script.
That will remove the local k8s cluster for you.
