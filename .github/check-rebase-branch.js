module.exports = ({github, context}) => {
  (async () => {
    const pull_req = await github.pulls.get({
      owner: context.repo.owner,
      repo: context.repo.repo,
      pull_number: context.payload.pull_request.number
    });
    console.log(pull_req);
    console.log(pull_req.head);
    console.log(pull_req.head.ref);
    if (pull_req.head.ref === "ppp") {
      throw "このbranchはrebase禁止";
    }
  })();
};